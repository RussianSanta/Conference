package ru.russun.conference.service;

import ru.russun.conference.dto.BranchDto;
import ru.russun.conference.dto.MessageDto;

import java.util.List;

public interface BranchService {
    BranchDto getBranch(Integer branchId);

    BranchDto addBranch(BranchDto branch);

    void deleteBranch(Integer branchId);

    BranchDto updateBranch(BranchDto branch, Integer branchId);

    List<BranchDto> getAllBranches();

    List<BranchDto> getAllBranchesInRoom(Integer roomId);
}
