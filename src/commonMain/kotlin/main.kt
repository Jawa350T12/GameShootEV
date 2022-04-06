import com.soywiz.klock.seconds
import com.soywiz.korev.Key
import com.soywiz.korge.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.degrees
import com.soywiz.korma.interpolation.Easing

suspend fun main() = Korge(bgcolor = Colors["#2b2b2b"],
    width = 1440,
    height = 900,
    virtualWidth = 1200,
    virtualHeight = 660,
    title = "ShootGame",
    iconPath = "50.jpg",
    //clipBorders = false
    ) {

	val rect = solidRect(5000.0,5000.0, Colors.DARKCYAN)

    val rectmin = solidRect(100.0,100.0,Colors.BISQUE).xy(600,330)
    val circle = circle(25.0, Colors.DARKRED)

    circle.addUpdater {

        if(views.input.keys[Key .S]){
            y++
        }
        if(views.input.keys[Key .W]){
            y--
        }
        if(views.input.keys[Key .D]){
            x++
        }
        if(views.input.keys[Key .A]){
            x--
        }
    }

    circle.onCollision( { it == rectmin } ){
        if((circle.x<rectmin.x)){
            x--;
        }
        if((circle.y<rectmin.y)){
            y--;
        }
        if((circle.x>rectmin.x)){
            x++;
        }
        if((circle.y>rectmin.y)){
            y++;
        }
    }
}