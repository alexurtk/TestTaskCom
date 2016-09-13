import org.hamcrest.CoreMatchers;
import org.junit.Test;
import ru.tkachenko.Company;
import ru.tkachenko.CompanyServiceImpl;
import ru.tkachenko.ICompanyService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by a.tkachenko on 12.09.2016.
 */
public class CompanyServiceTest {

    private final Company root = new Company(1,null, 10);
    private final Company manager = new Company(2,this.root, 10);
    private final Company dev = new Company(3,this.manager, 10);
    private final ICompanyService service = new CompanyServiceImpl();
    private final List<Company> comps = Arrays.asList(this.root, this.manager, this.dev);

    @Test
    public void  whenCompanySingleThenTopTheSameCompany(){
        Company result = this.service.getTopLevelParent(this.root);
        assertThat(result, is(this.root));
    }

    @Test
    public void whenCompanyInChainThenTopWithParentNull(){
        Company result = this.service.getTopLevelParent(this.dev);
        assertThat(result, is(this.root));
    }

    @Test
    public void  whenCompanySingleThenEmployeesOnlyInIt(){
        long result = this.service.getEmployeeCountForCompanyAndChildren(this.dev, this.comps);
        assertThat(result, is(10L));
    }

    public void whenThreeCompanyThenSumEmployees(){
        long result = this.service.getEmployeeCountForCompanyAndChildren(this.root, this.comps);
        assertThat(result, is(30L));
    }
}
