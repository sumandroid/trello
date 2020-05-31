package services;

import domain.models.Member;
import domain.models.Project;

import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService{

    private Project project;

    public UserServiceImpl(Project project){
        this.project = project;
    }

    @Override
    public Member findById(UUID id) {
        Optional<Member> memberoptional = project.getMembers()
                .stream().filter(m -> m.getId().equals(id)).findFirst();
        if(memberoptional.isPresent()){
            return memberoptional.get();
        }
        throw new RuntimeException("No member found with id: " + id);
    }

    @Override
    public Member findByEmail(String email) {
        Optional<Member> memberoptional = project.getMembers()
                .stream().filter(m -> m.getEmail().equals(email)).findFirst();
        if(memberoptional.isPresent()){
            return memberoptional.get();
        }
        throw new RuntimeException("No member found with email: " + email);
    }
}
