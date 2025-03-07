package com.example.ecom.model.service

import android.util.Log
import com.example.ecom.model.product.FireStoreRepository
import com.example.ecom.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject



/*class AccountServiceImpl
@Inject
constructor(

) : AccountService
{
    override val currentUser: Flow<User?>
        get() =
            callbackFlow{
                val listener =
                    FirebaseAuth.AuthStateListener{ auth->
                        val firebaseUser = auth.currentUser
                        if(firebaseUser?.isAnonymous == true && firebaseUser.email == null){
                            trySend(null)
                        } else {
                            trySend(firebaseUser.toUser())
                        }
                    }
                Firebase.auth.addAuthStateListener(listener)
                awaitClose { Firebase.auth.removeAuthStateListener(listener) }
            }

    override val currentUserId: String
        get() =
            Firebase.auth.currentUser?.uid.orEmpty()

    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override fun getUserProfile(): User {
        return Firebase.auth.currentUser.toUser()
    }

    override suspend fun createAnonymousAccount() {
        Firebase.auth.signInAnonymously().await()
    }

    override suspend fun updateDisplayName(newDisplayName: String) {
        val profileUpdates =
            userProfileChangeRequest{
                displayName = newDisplayName
            }
        Firebase.auth.currentUser!!.updateProfile(profileUpdates).await()
    }

    override suspend fun signInWithGoogle(idToken: String) {
        val firebaseCredential = GoogleAuthProvider.getCredential(idToken,null)
        Firebase.auth.signInWithCredential(firebaseCredential).await()
    }

    override suspend fun signInWithEmail(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email,password).await()
    }

    override suspend fun signOut() {
        Firebase.auth.signOut()
    }

    override suspend fun deleteAccount() {
        Firebase.auth.currentUser!!.delete().await()
    }

    override suspend fun linkAccountWithEmail(email: String, password: String) {
        Firebase.auth.createUserWithEmailAndPassword(email,password).await()
    }

    private fun FirebaseUser?.toUser() : User =
        if (this == null){
            User()
        }else{
            User(
                id = this.uid,
                email = this.email ?: "",
                provider = this.providerId,
                displayName = this.displayName ?: "",
                isAnonymous = this.isAnonymous
            )
        }
}*/

class AccountServiceImpl
@Inject
constructor(
    private val fireStoreRepository: FireStoreRepository
) : AccountService {

    override val currentUser: Flow<User?>
        get() =
            callbackFlow {
                val listener =
                    FirebaseAuth.AuthStateListener { auth ->
                        val firebaseUser = auth.currentUser
                        if (firebaseUser?.isAnonymous == true && firebaseUser.email == null) {
                            trySend(null)
                        } else {
                            trySend(firebaseUser.toUser())
                        }
                    }
                Firebase.auth.addAuthStateListener(listener)
                awaitClose { Firebase.auth.removeAuthStateListener(listener) }
            }

    override val currentUserId: String
        get() =
            Firebase.auth.currentUser?.uid.orEmpty()

    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override fun getUserProfile(): User {
        return Firebase.auth.currentUser.toUser()
    }

    override suspend fun createAnonymousAccount() {
        Firebase.auth.signInAnonymously().await()
    }

    override suspend fun updateDisplayName(newDisplayName: String) {
        val profileUpdates =
            userProfileChangeRequest {
                displayName = newDisplayName
            }
        Firebase.auth.currentUser!!.updateProfile(profileUpdates).await()
        fireStoreRepository.updateUser(currentUserId, mapOf("displayName" to newDisplayName))
    }

    override suspend fun signInWithGoogle(idToken: String) {
        val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
        Firebase.auth.signInWithCredential(firebaseCredential).await()
        createUserInFirestoreIfNotExists()
    }

    override suspend fun signInWithEmail(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password).await()
        createUserInFirestoreIfNotExists()
    }

    override suspend fun signOut() {
        Firebase.auth.signOut()
    }

    override suspend fun deleteAccount() {
        Firebase.auth.currentUser!!.delete().await()
        fireStoreRepository.updateUser(currentUserId, emptyMap()) // Handle Firestore data deletion
    }

    override suspend fun linkAccountWithEmail(email: String, password: String) {
        Firebase.auth.createUserWithEmailAndPassword(email, password).await()
        createUserInFirestoreIfNotExists()
    }

    // Helper to create Firestore user if not exists
    private suspend fun createUserInFirestoreIfNotExists() {
        val firebaseUser = Firebase.auth.currentUser
        Log.d("login", "createUserInFirestoreIfNotExists: $firebaseUser")
        if (firebaseUser != null && !fireStoreRepository.userExists(firebaseUser.uid)) {
            val newUser = User(
                id = firebaseUser.uid,
                email = firebaseUser.email.orEmpty(),
                displayName = firebaseUser.displayName.orEmpty(),
                isAnonymous = firebaseUser.isAnonymous
            )
            fireStoreRepository.saveUser(newUser)
        }
    }

    private fun FirebaseUser?.toUser(): User =
        if (this == null) {
            User()
        } else {
            User(
                id = this.uid,
                email = this.email ?: "",
                provider = this.providerId,
                displayName = this.displayName ?: "",
                isAnonymous = this.isAnonymous
            )
        }
}

