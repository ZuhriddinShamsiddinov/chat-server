package uz.boom.chatserver.service.base;

import lombok.RequiredArgsConstructor;
import uz.boom.chatserver.mappers.base.BaseMapper;
import uz.boom.chatserver.repository.base.BaseRepository;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:10 PM 10/9/22 on Sunday in October
 */
@RequiredArgsConstructor
public class GenericService<R extends BaseRepository, M extends BaseMapper> implements BaseService {
    protected final R repository;
    protected final M mapper;
}
