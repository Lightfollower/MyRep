package root;

public class WebFinanceInfoBuilder implements FinanceInfoBuilder
{
    @Override
    @Deprecated
    public FinanceInformation buildFinacneInformation() {
        System.out.println("Вызов метода для объекта WebFinanceInfoBuilder");
        return new FinanceInformation();
    }
}
