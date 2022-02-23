package ru.russun.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.russun.conference.dto.MemberDto;
import ru.russun.conference.entity.Member;
import ru.russun.conference.entity.Room;
import ru.russun.conference.repos.MemberRepos;
import ru.russun.conference.repos.RoomRepos;
import ru.russun.conference.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements MemberService {
    @Autowired
    RoomRepos roomRepos;
    @Autowired
    MemberRepos memberRepos;

    @Override
    public MemberDto getMember(Integer memberId) {
        return MemberDto.from(memberRepos.findById(memberId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public MemberDto addMember(MemberDto memberDto) {
        Room roomFromDto = roomRepos.findById(memberDto.getRoomId()).orElseThrow(IllegalArgumentException::new);
        Member member = Member.builder()
                .room(roomFromDto)
                .name(memberDto.getName())
                .build();
        memberRepos.save(member);
        return MemberDto.from(member);
    }

    @Override
    public void deleteMember(MemberDto memberDto) {
        memberRepos.deleteById(memberDto.getId());
    }

    @Override
    public MemberDto updateMember(MemberDto memberDto, Integer memberId) {
        Member memberToUpdate = memberRepos.findById(memberId).orElseThrow(IllegalArgumentException::new);
        memberToUpdate.setName(memberDto.getName());
        memberRepos.save(memberToUpdate);
        return MemberDto.from(memberToUpdate);
    }

    @Override
    public List<MemberDto> getAllMembers() {
        return memberRepos.findAll().stream().map(MemberDto::from).collect(Collectors.toList());
    }
}
