package root;

public class DbFinanceInfoBuilder implements FinanceInfoBuilder
{
    @Override
    @Deprecated
    public FinanceInformation buildFinacneInformation() {
        System.out.println("Вызов метода для объекта DbFinanceInfoBuilder");
        return new FinanceInformation();
    }
}
