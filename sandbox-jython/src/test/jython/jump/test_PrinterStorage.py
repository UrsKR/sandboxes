from unittest import TestCase
import ast
from printer import PrinterStorage
from printer import VisitChildren
from printer import ModulePrinter


class TestPrinterStorage(TestCase):
    def setUp(self):
        self.storage = PrinterStorage()

    def test_justVisitAllChildrenIfNoSpecialPrinterIsRegistered(self):
        self.assertEqual(type(self.storage[ast.Module]), VisitChildren)

    def test_useThePrinterThatIsRegisteredForTheAstClass(self):
        self.storage[ast.Module] = ModulePrinter()
        self.assertEqual(type(self.storage[ast.Module]), ModulePrinter)