package dev.jianastrero.trainer.domain.enumeration

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import dev.jianastrero.trainer.ui.theme.Dark
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
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

@OptIn(ExperimentalSerializationApi::class)
@Serializable
enum class PokemonType(
    val color: Color,
    val icon: DrawableResource?,
) {
    @JsonNames("normal", "Normal") Normal(Color(0xFFA8A77A), Res.drawable.normal),
    @JsonNames("fighting", "Fighting") Fighting(Color(0xFFC22E28), Res.drawable.fighting),
    @JsonNames("flying", "Flying") Flying(Color(0xFFA98FF3), Res.drawable.flying),
    @JsonNames("poison", "Poison") Poison(Color(0xFFA33EA1), Res.drawable.poison),
    @JsonNames("ground", "Ground") Ground(Color(0xFFE2BF65), Res.drawable.ground),
    @JsonNames("rock", "Rock") Rock(Color(0xFFB6A136), Res.drawable.rock),
    @JsonNames("bug", "Bug") Bug(Color(0xFFA6B91A), Res.drawable.bug),
    @JsonNames("ghost", "Ghost") Ghost(Color(0xFF735797), Res.drawable.ghost),
    @JsonNames("steel", "Steel") Steel(Color(0xFFB7B7CE), Res.drawable.steel),
    @JsonNames("fire", "Fire") Fire(Color(0xFFEE8130), Res.drawable.fire),
    @JsonNames("water", "Water") Water(Color(0xFF6390F0), Res.drawable.water),
    @JsonNames("grass", "Grass") Grass(Color(0xFF7AC74C), Res.drawable.grass),
    @JsonNames("electric", "Electric") Electric(Color(0xFFF7D02C), Res.drawable.electric),
    @JsonNames("psychic", "Psychic") Psychic(Color(0xFFF95587), Res.drawable.psychic),
    @JsonNames("ice", "Ice") Ice(Color(0xFF96D9D6), Res.drawable.ice),
    @JsonNames("dragon", "Dragon") Dragon(Color(0xFF6F35FC), Res.drawable.dragon),
    @JsonNames("dark", "Dark") Dark(Color(0xFF705746), Res.drawable.dark),
    @JsonNames("fairy", "Fairy") Fairy(Color(0xFFD685AD), Res.drawable.fairy),
    @JsonNames("stellar", "Stellar") Stellar(Color(0xFF46647E), null),
    @JsonNames("unknown", "Unknown") Unknown(Color(0xFF827E7A), null),
    @JsonNames("shadow", "Shadow") Shadow(Color(0xFF2B4463), null),
}
