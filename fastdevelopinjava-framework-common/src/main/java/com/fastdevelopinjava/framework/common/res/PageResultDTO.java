package com.fastdevelopinjava.framework.common.res;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class PageResultDTO<T> implements Serializable {
   private Long total;
   private List<T> list;
}
