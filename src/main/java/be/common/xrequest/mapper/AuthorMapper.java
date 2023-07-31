package be.common.xrequest.mapper;

import be.common.xrequest.domain.author.Author;
import be.common.xrequest.domain.author.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    PlaceMapper placeMapper;

    public AuthorDto mapAuthorToAuthorDto(Author author) {
        return new AuthorDto()
                .setId(author.getId().toString())
                .setName(author.getName())
                .setSurName(author.getSurName())
                .setNickName(author.getNickName())
                .setAge(author.getAge())
                .setEmail(author.getEmail())
                .setPhoneNumber(author.getPhoneNumber())
                .setPlace(author.getPlace());
    }

    public Author mapAuthorDtoToAuthor(AuthorDto authorDto) {
        return new Author(
                authorDto.getNickName(),
                authorDto.getName(),
                authorDto.getSurName(),
                authorDto.getEmail(),
                authorDto.getPhoneNumber(),
                authorDto.getAge(),
                authorDto.getPlace());
    }
}
