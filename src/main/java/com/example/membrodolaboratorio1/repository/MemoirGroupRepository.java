package com.example.membrodolaboratorio1.repository;

import com.example.membrodolaboratorio1.entity.MemoirGroup;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class MemoirGroupRepository {
    private Collection<MemoirGroup> memoirGroupCollection;

    public MemoirGroupRepository(Collection<MemoirGroup> memoirGroupCollection) {
        this.memoirGroupCollection = memoirGroupCollection;
    }

    public boolean save(MemoirGroup memoirGroup){
        return this.memoirGroupCollection.add(memoirGroup);
    }

    public Optional<MemoirGroup> getOne(String id){
        return memoirGroupCollection.stream().filter(memoirGroup -> memoirGroup.getId().equals(id)).findFirst();
    }

    public Collection<MemoirGroup> getAll() {
        return memoirGroupCollection;
    }

}
