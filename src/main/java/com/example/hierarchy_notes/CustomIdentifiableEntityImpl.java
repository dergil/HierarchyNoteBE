package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.model.IdentifiableEntity;
import com.github.vincemann.springrapid.core.util.LazyLogUtils;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

// Id is generated in FE
@MappedSuperclass
@NoArgsConstructor
public class CustomIdentifiableEntityImpl<Id extends Serializable>
        implements IdentifiableEntity<Id> {


//    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Id id;

    @Override
    public Id getId() {
        return this.id;
    }

    @Override
    public void setId(Id id) {
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl<?> other = (com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl<?>) o;
        //added null check here, otherwise entities with null ids are considered equal
        //and cut down to one entity in a set for example
        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return LazyLogUtils.toString(this);
    }
}