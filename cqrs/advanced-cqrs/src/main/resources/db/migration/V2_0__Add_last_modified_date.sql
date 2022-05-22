ALTER table cqrs.post ADD column last_modified_date TIMESTAMP WITHOUT TIME ZONE default NOW();
ALTER table cqrs.comment ADD column last_modified_date TIMESTAMP WITHOUT TIME ZONE default NOW();
ALTER table cqrs.comment_reaction ADD column last_modified_date TIMESTAMP WITHOUT TIME ZONE default NOW();