import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.runpath.database.SessionManager
@Composable
fun ProfilePage(navController: NavController, sessionManager: SessionManager) {
    val sharedPreferences = sessionManager.getsharedPreferences()
    val username = sharedPreferences.getString("username", "N/A")
    val email = sharedPreferences.getString("email", "N/A")
    val dateCreated = sharedPreferences.getString("dateCreated", "N/A")

    println("profile accessed")  // Debugging statement

    Column(modifier = Modifier.fillMaxSize()) {  // Ensure the column takes up available space
        Text(text = "Username: $username")
        Text(text = "Email: $email")
        Text(text = "Date Created: $dateCreated")

        Button(
            onClick = {
                sessionManager.clearSession()
                navController.navigate("loginPage") {
                    popUpTo("loginPage") { inclusive = true }
                }
            }
        ) {
            Text("Logout")
        }

        Button(
            onClick = {
                navController.navigate("changePasswordPage")
            }
        ) {
            Text("Change Password")
        }
    }
}
