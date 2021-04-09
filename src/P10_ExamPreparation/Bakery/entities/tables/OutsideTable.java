package P10_ExamPreparation.Bakery.entities.tables;

import P10_ExamPreparation.Bakery.entities.tables.BaseTable;

public class OutsideTable extends BaseTable {
    private static final double PRICE_PER_PERSON = 3.50;

    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
