package ru.russun.conference.service;

import ru.russun.conference.dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto getMember(Integer memberId);

    MemberDto addMember(MemberDto member);

    void deleteMember(MemberDto member);

    MemberDto updateMember(MemberDto member, Integer memberId);

    List<MemberDto> getAllMembers();
}
