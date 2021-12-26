package ru.russun.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.russun.conference.dto.BranchDto;
import ru.russun.conference.dto.MessageDto;
import ru.russun.conference.dto.RoomDto;
import ru.russun.conference.service.BranchService;

import java.util.List;

@RestController
@CrossOrigin
public class BranchController {
    @Autowired
    BranchService branchService;

    @GetMapping("/branches")
    public List<BranchDto> getAllBranches(@RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<BranchDto> branches = branchService.getAllBranches();
        if (!expand) {
            for (BranchDto branch : branches) {
                branch.setRoom(RoomDto.builder().id(branch.getRoom().getId()).build());
            }
        }
        return branches;
    }

    @GetMapping("/branches/{branch-id}")
    public BranchDto getBranch(@PathVariable("branch-id") Integer id,
                               @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        BranchDto branch = branchService.getBranch(id);
        if (!expand) branch.setRoom(RoomDto.builder().id(branch.getRoom().getId()).build());
        return branch;
    }

    @GetMapping("/rooms/{room-id}/branches")
    public List<BranchDto> getBranchsByOwner(@PathVariable("room-id") Integer id,
                                             @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        List<BranchDto> branches = branchService.getAllBranchesInRoom(id);
        if (!expand) {
            for (BranchDto branch : branches) {
                branch.setRoom(RoomDto.builder().id(branch.getRoom().getId()).build());
            }
        }
        return branches;
    }

    @PostMapping("/branches")
    public BranchDto createNewBranch(@RequestBody BranchDto branchDto,
                                     @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        BranchDto branch = branchService.addBranch(branchDto);
        if (!expand) branch.setRoom(RoomDto.builder().id(branch.getRoom().getId()).build());
        return branch;
    }

    @PutMapping("/branches/{Branch-id}")
    public BranchDto updateBranchData(@RequestBody BranchDto BranchDto, @PathVariable("Branch-id") Integer id,
                                      @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        BranchDto branch = branchService.updateBranch(BranchDto, id);
        if (!expand) branch.setRoom(RoomDto.builder().id(branch.getRoom().getId()).build());
        return branch;
    }

    @DeleteMapping("/branches/{branch-id}")
    public void deleteBranch(@PathVariable("branch-id") Integer id) {
        branchService.deleteBranch(id);
    }
}
