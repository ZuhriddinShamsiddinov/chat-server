package uz.boom.chatserver.controllers.base;

import lombok.RequiredArgsConstructor;
import uz.boom.chatserver.service.base.BaseService;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:25 PM 10/9/22 on Sunday in October
 */
@RequiredArgsConstructor
public class GenericController<S extends BaseService> implements BaseController {
    protected final S service;
    protected static final String API = "/api";
    protected static final String VERSION = "/v1";
    protected static final String PATH = API + VERSION;

}
