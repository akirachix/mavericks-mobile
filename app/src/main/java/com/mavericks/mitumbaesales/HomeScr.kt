package com.mavericks.mitumbaesales.screens
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.pager.*
import com.mavericks.mitumbaesales.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.res.painterResource



val Poppins = try {
    FontFamily(
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_bold, FontWeight.Bold)
    )
} catch (_: Exception) {
    FontFamily.Default
}

val offerList = listOf(
    "https://images.unsplash.com/photo-1512436991641-6745cdb1723f"
)

val categoryList = listOf(
    "High quality" to "https://plus.unsplash.com/premium_photo-1679056835084-7f21e64a3402?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Y2xvdGhpbmd8ZW58MHx8MHx8fDA%3D",
    "Fashion finds" to "https://randomuser.me/api/portraits/women/44.jpg",
    "Women" to "https://randomuser.me/api/portraits/women/45.jpg",
    "Men" to "https://randomuser.me/api/portraits/men/46.jpg",
    "Kids" to "https://randomuser.me/api/portraits/lego/2.jpg"
)

val featuredProducts = listOf(
    Triple("Men Jacket", "1000 KSH", "https://images.unsplash.com/photo-1512436991641-6745cdb1723f"),
    Triple("Kids Dress", "500 KSH", "https://image.kilimall.com/kenya/shop/store/goods/6529/2023/04/168224472931368411d423c93459882a0fd0eb4cec9e9.jpg?x-image-process=image/format,webp/resize,w_720#"),
    Triple("Kids T-Shirt", "800 KSH", "https://images.unsplash.com/photo-1517841905240-472988babdf9"),
    Triple("Kids matching set", "400 KSH", "https://images.unsplash.com/photo-1566454544259-f4b94c3d758c?q=80&w=880&auto=format&fit=crop"),
    Triple("Women Skirt", "700 KSH", "https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcSA9jx4gJRJEQO1SWvCZ7w5MvGW7FnNEvzBxtuSmcxkL01iFfLsDM46EJL7t2YVlsoWNUZ-72a4MjBc2ianZ9SXttpnJR9axXbvqov3mZ4qqAj3JzKC-xoXxvN_M2nNGlUUMKjEohs&usqp=CAc"),
    Triple("Chiffon", "800 KSH", "https://images.unsplash.com/photo-1512436991641-6745cdb1723f")
)

@Composable
fun HomeScreen(
    username: String = "Marion!",
    onCategoryClick: (String) -> Unit = {},
    onProductClick: (String) -> Unit = {},
    bottomNavSelected: Int = 0,
    onBottomNavClick: (Int) -> Unit = {},
) {
    val pagerState = rememberPagerState()
    var searchQuery by remember { mutableStateOf("") }

    Box(Modifier.fillMaxSize().background(Color.White)) {
        Column(
            Modifier.fillMaxSize()
        ) {

            Box(
                Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFFFBC02D),
                        RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
                    )
            ) {
                Column(Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Hello, $username!",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF373737),
                            fontSize = 18.sp
                        )
                        Icon(
                            Icons.Filled.Notifications,
                            contentDescription = "Notifications",
                            tint = Color(0xFF373737)
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text("Search", fontFamily = Poppins) },
                            modifier = Modifier
                                .weight(1f)
                                .background(Color.White, RoundedCornerShape(12.dp))
                                .height(48.dp),
                            singleLine = true,
                            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null, tint = Color.Gray) },
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            )
                        )
                        Spacer(Modifier.width(8.dp))
                        Box(
                            Modifier
                                .size(48.dp)
                                .background(Color.White, RoundedCornerShape(12.dp))
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_filter),
                                contentDescription = "Filter",
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(10.dp))


            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 6.dp)
            ) {

                SectionHeader(title = "Special Offers", onSeeAll = {})
                SpecialOfferPager(pagerState = pagerState)
                DotIndicator(current = pagerState.currentPage, count = offerList.size)

                Spacer(Modifier.height(12.dp))


                SectionHeader(title = "Categories", onSeeAll = {})
                LazyRow(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 7.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(categoryList) { (name, url) ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable { onCategoryClick(name) }
                        ) {
                            AsyncImage(
                                model = url,
                                contentDescription = name,
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFE2E8F0), CircleShape)
                                    .border(2.dp, Color.White, CircleShape)
                            )
                            Text(
                                name,
                                fontFamily = Poppins,
                                fontSize = 11.sp,
                                color = Color(0xFF373737),
                                modifier = Modifier.width(62.dp),
                                maxLines = 2
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))


                SectionHeader(title = "Featured Products", onSeeAll = {})
                val featuredRows = featuredProducts.chunked(3)
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp, vertical = 7.dp)
                ) {
                    featuredRows.forEach { rowProducts ->
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            rowProducts.forEach { (title, price, url) ->
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(140.dp)
                                        .clickable { onProductClick(title) },
                                    shape = RoundedCornerShape(12.dp),
                                    elevation = CardDefaults.cardElevation(2.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.padding(bottom = 6.dp, top = 4.dp, start = 4.dp, end = 4.dp)
                                    ) {
                                        AsyncImage(
                                            model = url,
                                            contentDescription = title,
                                            modifier = Modifier
                                                .height(70.dp)
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(Color(0xFFF5F5F5))
                                        )
                                        Text(title, fontFamily = Poppins, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                        Text(price, fontFamily = Poppins, fontSize = 12.sp)
                                    }
                                }
                            }
                            repeat(3 - rowProducts.size) {
                                Spacer(Modifier.weight(1f))
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                    }
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(containerColor = Color(0xFF002367)),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val icons = listOf(
                        Icons.Filled.Home,
                        Icons.Filled.Apps,
                        Icons.Filled.ShoppingCart,
                        Icons.Filled.Person
                    )
                    icons.forEachIndexed { index, icon ->
                        val iconTint = if (index == 0) {
                            Color.White
                        } else {
                            if (bottomNavSelected == index) Color(0xFFFBC02D) else Color.White
                        }
                        Icon(
                            icon,
                            contentDescription = null,
                            tint = iconTint,
                            modifier = Modifier
                                .size(28.dp)
                                .clickable { onBottomNavClick(index) }
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun SectionHeader(title: String, onSeeAll: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF184685)
        )
        Text(
            "See all",
            color = Color(0xFF0B3D91),
            fontFamily = Poppins,
            fontSize = 13.sp,
            modifier = Modifier.clickable { onSeeAll() }
        )
    }
    Spacer(Modifier.height(4.dp))
}

@Composable
fun SpecialOfferPager(pagerState: PagerState) {
    HorizontalPager(
        count = offerList.size,
        state = pagerState,
        modifier = Modifier
            .height(98.dp)
            .fillMaxWidth()
    ) { page ->
        Card(
            Modifier.padding(horizontal = 16.dp).fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FFDD)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier
                        .weight(1f)
                        .padding(start = 14.dp)
                ) {
                    Text("Get Special Offer", fontWeight = FontWeight.Medium, fontFamily = Poppins, fontSize = 13.sp)
                    Text("Up to", fontFamily = Poppins, fontSize = 13.sp)
                    Text("30%", color = Color(0xFF0B3D91), fontWeight = FontWeight.Bold, fontFamily = Poppins, fontSize = 24.sp)
                    Button(
                        onClick = {},
                        contentPadding = PaddingValues(horizontal = 9.dp, vertical = 0.dp),
                        modifier = Modifier.padding(top = 2.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0B3D91)),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text("Shop Now", fontFamily = Poppins, fontSize = 12.sp)
                    }
                }
                AsyncImage(
                    model = offerList[page],
                    contentDescription = "Special Offer",
                    modifier = Modifier
                        .height(85.dp)
                        .width(83.dp)
                        .padding(end = 12.dp)
                        .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
                )
            }
        }
    }
}

@Composable
fun DotIndicator(current: Int, count: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(count) { index ->
            val selected = current == index
            Box(
                Modifier
                    .padding(horizontal = 3.dp)
                    .size(if (selected) 9.dp else 7.dp)
                    .clip(CircleShape)
                    .background(
                        if (selected) Color(0xFF237EEB) else Color.LightGray.copy(alpha = 0.7f)
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(username = "Marion!")
}
