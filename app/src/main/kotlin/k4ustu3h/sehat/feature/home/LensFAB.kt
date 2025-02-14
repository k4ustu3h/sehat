package k4ustu3h.sehat.feature.home

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import k4ustu3h.sehat.R

@Composable
fun LensFAB() {
    val context = LocalContext.current
    context.packageManager

    val launchGoogleLens = {
        val packageName = "com.google.ar.lens"
        var intent = context.packageManager.getLaunchIntentForPackage(packageName)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            intent?.addCategory(Intent.CATEGORY_LAUNCHER)
        }

        if (intent == null) {
            intent = Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=$packageName"));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    FloatingActionButton(
        onClick = launchGoogleLens,
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.size(56.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.google_lens),
            contentDescription = "Google Lens",
            modifier = Modifier.size(24.dp),
        )
    }
}