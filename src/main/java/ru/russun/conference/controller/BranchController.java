package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.BranchDto;
import ru.russun.conference.service.BranchService;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    BranchService branchService;

    @GetMapping("/branches")
    public List<BranchDto> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/branches/{branch-id}")
    public BranchDto getBranch(@PathVariable("branch-id") Integer id) {
        return branchService.getBranch(id);
    }

    @GetMapping("/rooms/{room-id}/branches")
    public List<BranchDto> getBranchsByOwner(@PathVariable("room-id") Integer id) {
        return branchService.getAllBranchesInRoom(id);
    }

    @PostMapping("/branches/new")
    public BranchDto createNewBranch(@RequestBody BranchDto branchDto) {
        return  branchService.addBranch(branchDto);
    }

    @PutMapping("/branches/{Branch-id}")
    public BranchDto updateBranchData(@RequestBody BranchDto BranchDto, @PathVariable("Branch-id") Integer id) {
        return branchService.updateBranch(BranchDto, id);
    }

    @DeleteMapping("/branches/{branch-id}")
    public void deleteBranch(@PathVariable("branch-id") Integer id) {
        branchService.deleteBranch(id);
    }
}
