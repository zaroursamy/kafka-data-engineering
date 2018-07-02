package model

import model.sink.ModelDatabase
import org.scalatest.FunSuite

class ProjectMonoidsTest extends FunSuite {

  test("combine two existing") {

    val m1 = ModelDatabase("0", 3, 2, 4, 2, "hello")
    val m2 = ModelDatabase("0", 3, 2, 0, 2, "hello")
    val m3 = ModelDatabase("0", 3, 2, 0, 2, "")

    val combined12 = ProjectMonoids.monoidDatabase.combine(m1, m2)
    val combined31 = ProjectMonoids.monoidDatabase.combine(m3, m1)

    assert(combined12 == ModelDatabase("0", 6, 4, 4, 4, "hello"))
    assert(combined31 == ModelDatabase("0", 6, 4, 4, 4, "hello"))
    println(combined12)
    println(combined31)
  }

}
