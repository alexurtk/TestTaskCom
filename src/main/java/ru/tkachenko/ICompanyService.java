package ru.tkachenko;

import java.util.List;

/**
 * Created by a.tkachenko on 12.09.2016.
 */
public interface ICompanyService {
    /**
     *
     * @param child - company for whom we are searching the top level parent
     * @return
     */
    Company getTopLevelParent(Company child);

    /**
     *
     * @param company - company for whom we searching count of employees
     * @param companies all available companies
     * @return
     */
    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);
}
