package com.douineau.batch.config;

import com.douineau.model.api.Author;
import com.douineau.model.api.Book;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Book> reader,
                   ItemProcessor<Book, Book> processor,
                   ItemWriter<Book> writer) {

        Step step = stepBuilderFactory
                .get("books-file-load")
                .<Book, Book>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

        return jobBuilderFactory.get("load-books")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<Book> bookFlatFileItemReader(
            @Value("${book.csv.input}") ClassPathResource classPathResource) {
        FlatFileItemReader<Book> reader = new FlatFileItemReader<>();
        reader.setResource(classPathResource);
        reader.setName("books-csv-reader");
        reader.setLinesToSkip(1);
        reader.setLineMapper(bookLineMapper());

        return reader;
    }

    @Bean
    public LineMapper<Book> bookLineMapper() {
        DefaultLineMapper<Book> bookLineMapper = new DefaultLineMapper<Book>();
        DelimitedLineTokenizer bookLineTokenizer = new DelimitedLineTokenizer();
        bookLineTokenizer.setDelimiter(",");
        bookLineTokenizer.setStrict(false);
        bookLineTokenizer.setNames(new String[] {"id", "name"});

        BeanWrapperFieldSetMapper<Book> bookMapper = new BeanWrapperFieldSetMapper<Book>();
        bookMapper.setTargetType(Book.class);

        bookLineMapper.setLineTokenizer(bookLineTokenizer);
        bookLineMapper.setFieldSetMapper(bookMapper);

        return bookLineMapper;
    }

    @Bean
    public LineMapper<Author> authorLineMapper() {

        DefaultLineMapper<Author> authorLineMapper = new DefaultLineMapper<Author>();
        DelimitedLineTokenizer authorLineTokenizer = new DelimitedLineTokenizer();
        authorLineTokenizer.setDelimiter(",");
        authorLineTokenizer.setStrict(false);
        authorLineTokenizer.setNames(new String[] {"author"});

        BeanWrapperFieldSetMapper<Author> authorMapper = new BeanWrapperFieldSetMapper<Author>();
        authorMapper.setTargetType(Author.class);

        authorLineMapper.setLineTokenizer(authorLineTokenizer);
        authorLineMapper.setFieldSetMapper(authorMapper);

        return authorLineMapper;
    }

}
