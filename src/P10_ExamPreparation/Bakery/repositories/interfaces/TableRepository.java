package P10_ExamPreparation.Bakery.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
