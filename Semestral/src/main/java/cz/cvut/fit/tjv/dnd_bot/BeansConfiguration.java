package cz.cvut.fit.tjv.dnd_bot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class BeansConfiguration {
    /*@Bean
    public UserFileRepository userFileRepository(
            @Value("${cz.cvut.fit.tjv.dnd_bot.dao.UserFileRepository.file}") Path path){
        return new UserFileRepository(path);
    }

    @Bean
    public ItemFileRepository itemFileRepository(
            @Value("${cz.cvut.fit.tjv.dnd_bot.dao.ItemFileRepository.file}") Path path){
        return new ItemFileRepository(path);
    }

    @Bean
    public CharacterFileRepository characterFileRepository(
            @Value("${cz.cvut.fit.tjv.dnd_bot.dao.CharacterFileRepository.file}") Path path){
        return new CharacterFileRepository(path);
    }*/

}
