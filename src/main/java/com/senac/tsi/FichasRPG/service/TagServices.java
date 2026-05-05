package com.senac.tsi.FichasRPG.service;





import com.senac.tsi.FichasRPG.assemblers.TagAssembler;
import com.senac.tsi.FichasRPG.domains.tags.Tag;
import com.senac.tsi.FichasRPG.exceptions.RPGAlreadyExistsException;
import com.senac.tsi.FichasRPG.exceptions.RPGNotFoundException;
import com.senac.tsi.FichasRPG.repositories.TagRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class TagServices {
    private final TagRepository repository;
    private final PagedResourcesAssembler<Tag> pagedResourcesAssembler;
    private final TagAssembler tagAssembler;

    TagServices(TagRepository repository,
                   PagedResourcesAssembler<Tag> pagedResourcesAssembler,
                   TagAssembler tagAssembler) {
        this.repository = repository;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.tagAssembler = tagAssembler;
    }

    public PagedModel<EntityModel<Tag>> getAll(Pageable pageable){
        var tags = repository.findAll(pageable);
        return pagedResourcesAssembler.toModel(tags, tagAssembler);
    }

    public EntityModel<Tag> getById(long id){
        var tag = repository.findById(id)
                .orElseThrow(()-> new RPGNotFoundException("Tag","Id",id));
        return tagAssembler.toModel(tag);
    }

    public EntityModel<Tag> getByName(String nome){
        var tag = repository.findByNome(nome).orElseThrow(
                ()-> new RPGNotFoundException("Tag","nome",nome));
        return tagAssembler.toModel(tag);
    }

    public EntityModel<Tag> create(Tag novaTag){
        if (!repository.existsByNome(novaTag.getNomeTag())){
            var saved = repository.save(novaTag);
            return tagAssembler.toModel(saved);
        }else{throw new RPGAlreadyExistsException("Tag","nome");}
    }

    public ResponseEntity<EntityModel<Tag>> edit(Tag updatedTag,long id){
        var tag = repository.findById(id)
                .orElseThrow(() -> new RPGNotFoundException("Tag","id",id));
        tag.;
    }

    public void delete(long id){
        Tag checkIfTagExists = repository.findById(id).orElseThrow(
                ()-> new RPGNotFoundException("Tag","id",id)
        );
        repository.delete(checkIfTagExists);
    }
}
