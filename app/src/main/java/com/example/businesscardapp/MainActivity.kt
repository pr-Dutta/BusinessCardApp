package com.example.businesscardapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val image = painterResource(R.drawable.android_logo)

        LogoNameAndTitle(
            image = image,
            ownerName = stringResource(R.string.name_of_the_owner),
            ownerPosition = stringResource(R.string.position_of_the_owner)
            )

        ContactInfo(
            email = stringResource(R.string.e_mail),
            phoneNumber = stringResource(R.string.phone_number),
            socialMedia = stringResource(R.string.social_media)
        )
    }
}

@Composable
fun LogoNameAndTitle(
    image: Painter,
    ownerName: String,
    ownerPosition: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "android logo",
            modifier = Modifier
                .width(200.dp)
        )

        Text(
            text = ownerName,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Text(
            text = ownerPosition,
            Modifier.padding(8.dp),
            fontSize = 16.sp
        )
    }
}

@Composable
fun ContactInfo(
    email: String,
    phoneNumber: String,
    socialMedia: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                /* It will take the material Icons */
                imageVector = Icons.Default.Email,
                contentDescription = "e-mail Icon",
                Modifier.size(14.dp),
                                        /* tint for color of Icon // new */
                tint = Color(0xFF00FF00)
            )

            Text(
                text = email,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                /* It will take the material Icons */
                imageVector = Icons.Default.Phone,
                contentDescription = "Phone Icon",
                Modifier.size(14.dp),
                tint = Color(0xFF00FF00)
            )

            Text(
                text = phoneNumber,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 14.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                /* It will take the material Icons */
                imageVector = Icons.Default.Face,
                contentDescription = "Social media Icon",
                Modifier.size(14.dp),
                tint = Color(0xFF00FF00)
            )

            Text(
                text = socialMedia,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(14.dp)
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "BusinessCardAApp"
)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}