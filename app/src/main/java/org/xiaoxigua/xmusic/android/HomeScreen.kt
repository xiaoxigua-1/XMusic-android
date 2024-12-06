package org.xiaoxigua.xmusic.android

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.xiaoxigua.xmusic.android.components.PlaylistItem
import org.xiaoxigua.xmusic.android.room.UserViewModel
import org.xiaoxigua.xmusic.android.ui.theme.XMusicTheme

@Composable
fun HomeScreen(userViewModel: UserViewModel) {
    val playlist by userViewModel.allPlaylist.observeAsState(emptyList())

    LazyColumn(modifier = Modifier.padding(vertical = 10.dp)) {
        items(playlist, key = { it.playlistId }) {
            PlaylistItem(it.title, it.description, {}, {
                userViewModel.deletePlaylist(it)
            }, {})
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    XMusicTheme {
        HomeScreen(viewModel())
    }
}