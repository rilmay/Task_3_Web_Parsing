package com.epam.parsing.service.writer;

import com.epam.parsing.entity.XmlEntity;

import java.util.List;

public interface XMLWriter<T extends XmlEntity> {
    boolean write(List<T> list, String path);
}
