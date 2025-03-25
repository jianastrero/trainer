package dev.jianastrero.trainer.domain.enumeration

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.bug
import trainer.composeapp.generated.resources.compose_multiplatform
import trainer.composeapp.generated.resources.dark
import trainer.composeapp.generated.resources.dragon
import trainer.composeapp.generated.resources.electric
import trainer.composeapp.generated.resources.fairy
import trainer.composeapp.generated.resources.fighting
import trainer.composeapp.generated.resources.fire
import trainer.composeapp.generated.resources.flying
import trainer.composeapp.generated.resources.ghost
import trainer.composeapp.generated.resources.grass
import trainer.composeapp.generated.resources.ground
import trainer.composeapp.generated.resources.ice
import trainer.composeapp.generated.resources.normal
import trainer.composeapp.generated.resources.poison
import trainer.composeapp.generated.resources.psychic
import trainer.composeapp.generated.resources.rock
import trainer.composeapp.generated.resources.steel
import trainer.composeapp.generated.resources.water

@Serializable
enum class PokemonType(
    val color: Color,
    val icon: DrawableResource?,
) {
    @SerialName("normal") Normal(Color(0xFFA8A77A), Res.drawable.normal),
    @SerialName("fighting") Fighting(Color(0xFFC22E28), Res.drawable.fighting),
    @SerialName("flying") Flying(Color(0xFFA98FF3), Res.drawable.flying),
    @SerialName("poison") Poison(Color(0xFFA33EA1), Res.drawable.poison),
    @SerialName("ground") Ground(Color(0xFFE2BF65), Res.drawable.ground),
    @SerialName("rock") Rock(Color(0xFFB6A136), Res.drawable.rock),
    @SerialName("bug") Bug(Color(0xFFA6B91A), Res.drawable.bug),
    @SerialName("ghost") Ghost(Color(0xFF735797), Res.drawable.ghost),
    @SerialName("steel") Steel(Color(0xFFB7B7CE), Res.drawable.steel),
    @SerialName("fire") Fire(Color(0xFFEE8130), Res.drawable.fire),
    @SerialName("water") Water(Color(0xFF6390F0), Res.drawable.water),
    @SerialName("grass") Grass(Color(0xFF7AC74C), Res.drawable.grass),
    @SerialName("electric") Electric(Color(0xFFF7D02C), Res.drawable.electric),
    @SerialName("psychic")Psychic(Color(0xFFF95587), Res.drawable.psychic),
    @SerialName("ice") Ice(Color(0xFF96D9D6), Res.drawable.ice),
    @SerialName("dragon") Dragon(Color(0xFF6F35FC), Res.drawable.dragon),
    @SerialName("dark") Dark(Color(0xFF705746), Res.drawable.dark),
    @SerialName("fairy") Fairy(Color(0xFFD685AD), Res.drawable.fairy),
    @SerialName("stellar") Stellar(Color(0xFF46647E), null),
    @SerialName("unknown") Unknown(Color(0xFF827E7A), null),
    @SerialName("shadow") Shadow(Color(0xFF2B4463), null),
}
