package no.bouvet.sandvika.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.bouvet.sandvika.domain.Athlete;
import no.bouvet.sandvika.domain.Club;
import no.bouvet.sandvika.repository.AthleteRepository;

@Component
public class ClubResolver implements GraphQLResolver<Club>
{
    private final AthleteRepository athletesRepository;

    @Autowired
    public ClubResolver(AthleteRepository athletesRepository)
    {
        this.athletesRepository = athletesRepository;
    }

    public List<Athlete> athletes(Club club)
    {
        return athletesRepository.findByClubs_Id(club.getId());
    }
}