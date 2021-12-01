package ru.russun.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.BranchDto;
import ru.russun.conference.entity.Branch;
import ru.russun.conference.repos.BranchRepos;
import ru.russun.conference.repos.RoomRepos;
import ru.russun.conference.service.BranchService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    RoomRepos roomRepos;
    @Autowired
    BranchRepos branchRepos;

    @Override
    public BranchDto getBranch(Integer branchId) {
        return BranchDto.from(branchRepos.findById(branchId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public BranchDto addBranch(BranchDto branch, Integer roomId) {
        Branch branchToAdd = Branch.builder()
            .name(branch.getName())
            .room(roomRepos.findById(roomId).orElseThrow(IllegalArgumentException::new))
            .build();

        branchRepos.save(branchToAdd);

        return BranchDto.from(branchToAdd);
    }

    @Override
    public void deleteBranch(Integer branchId) {
        branchRepos.deleteById(branchId);
    }

    @Override
    public BranchDto updateBranch(BranchDto branch, Integer branchId) {
        Branch branchToUpdate = branchRepos.findById(branchId).orElseThrow(IllegalArgumentException::new);

        branchToUpdate.setName(branch.getName());

        branchRepos.save(branchToUpdate);

        return BranchDto.from(branchToUpdate);
    }

    @Override
    public List<BranchDto> getAllBranches() {
        return branchRepos.findAll().stream().map(BranchDto::from).collect(Collectors.toList());
    }
}
