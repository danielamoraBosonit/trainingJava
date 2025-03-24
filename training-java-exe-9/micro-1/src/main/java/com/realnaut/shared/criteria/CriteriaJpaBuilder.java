package com.realnaut.shared.criteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CriteriaJpaBuilder<T> {

    public Specification<T> addSpec(Object value, String field,
                                                 Specification<T> specification) {
        if (value != null) {
            SearchCriteria searchCriteria = new SearchCriteria(field, value);
            return getSpecification(searchCriteria, specification);
        }
        return specification;
    }

    private Specification<T> getSpecification(SearchCriteria criteria, Specification<T> specification) {
        CriteriaJpaSpecification<T> spec = new CriteriaJpaSpecification<T>(criteria);
        specification = specification == null ? spec : specification.and(spec);
        return specification;
    }


}
