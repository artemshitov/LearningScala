import org.scalatest.FunSuite
import ru.artemshitov.reciprocalcycles.RepeatingDecimal

class RepeatingDecimalSuite extends FunSuite {
  test ("converts fractions correctly") {
    expectResult("1.0") { RepeatingDecimal(1, 1).toString }
    expectResult("0.5") { RepeatingDecimal(1, 2).toString }
    expectResult("0.(3)") { RepeatingDecimal(1, 3).toString }
    expectResult("0.1(6)") { RepeatingDecimal(1, 6).toString }
  }
}
