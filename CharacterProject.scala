package com.wiley.characterProject

trait PowerUp{
  def powerUp()
}


abstract class Character{
  def Stats(health:Int)
  var attack = 20
  var defence = 20
}

class Hero extends Character with PowerUp{
  override def powerUp(): Unit = {
    attack += 10
  }

  override def Stats(health:Int): Unit = {
    println("health: " + health)
    println("Attack: " + attack)
    println("defence: " + defence)
  }


}


class Villain extends Character{
  attack = 30
  defence = 10
  final var shield = 15

  override def Stats(health:Int): Unit = {
    println("health: " + health)
    println("Attack: " + attack)
    println("defence: " + defence)
    println("shield: " + shield)
  }
}

class Minion extends Villain{
  attack = 5
  defence = 5

  override def Stats(health: Int): Unit = {
    println("health: " + health)
    println("Attack: " + attack)
    println("defence: " + defence)
    println("shield: " + shield)
  }
}

object CharacterProject extends App {
  println("Input Hero health: ")
  var hHealth = scala.io.StdIn.readInt()

  println("Hero Stats:")
  var h = new Hero
  h.Stats(hHealth)
  println()

  println("Do you want to power up?")
  var pPrompt = scala.io.StdIn.readLine()

  if (pPrompt == "yes") {
    h.powerUp()
    println("Attack up!")
    println("New Hero Stats:")
    h.Stats(hHealth)
  }

  println()

  println("Input Villain health: ")
  var vHealth = scala.io.StdIn.readInt()
  println()


  println("Villain Stats:")
  var v = new Villain
  v.Stats(vHealth)
  println()

  println("How many minions would you like: ")
  var minionNum = scala.io.StdIn.readInt()
  var count = 1

  while(count < minionNum+1){

    println("Minion" + count + " Stats:")
    var m = new Minion
    v.Stats(25)
    println()
    count += 1
  }


}
