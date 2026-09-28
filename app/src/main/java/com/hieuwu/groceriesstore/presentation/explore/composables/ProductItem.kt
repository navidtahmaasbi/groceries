package com.hieuwu.groceriesstore.presentation.explore.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.hieuwu.groceriesstore.R
import com.hieuwu.groceriesstore.domain.models.ProductModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: ProductModel,
    onAddToCartClick: (ProductModel) -> Unit,
    onNavigateToProductDetails: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = 1.dp,
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, colorResource(R.color.warm_outline)),
        onClick = { onNavigateToProductDetails(product.id) }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp),
        ) {
            AsyncImage(
                contentScale = ContentScale.Fit,
                model = product.image,
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Text(
                modifier = modifier.fillMaxWidth(), text = product.name ?: "",
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = modifier.height(4.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = product.description ?: "",
                maxLines = 2,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                color = colorResource(R.color.text_secondary),
            )
            Spacer(modifier = modifier.height(4.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${product.price}$",
                    style = MaterialTheme.typography.h6
                )
                Button(
                    onClick = { onAddToCartClick(product) },
                    modifier = Modifier.size(48.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.colorPrimary)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add ${product.name.orEmpty()} to basket",
                        tint = androidx.compose.ui.res.colorResource(com.hieuwu.groceriesstore.R.color.warm_white),
                    )
                }
            }
        }
    }
}