package ru.tkachenko;

import java.util.List;

/**
 * Created by a.tkachenko on 12.09.2016.
 */
public class CompanyServiceImpl implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company child) {
        Company result = child;
        if (child.getParent() != null){
            result = this.getTopLevelParent(child.getParent());
        }
        return result;
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long result = company.getEmployeeCount();
        for (Company comp : companies){
            if (comp.getParent() != null && comp.getParent().equals(company)){
                result += this.getEmployeeCountForCompanyAndChildren(comp, companies);

            }
        }
        return result;
    }
}
