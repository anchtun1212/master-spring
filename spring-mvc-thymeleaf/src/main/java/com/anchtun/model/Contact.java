package com.anchtun.model;

import lombok.Data;

/**
 * 
 * add @Data lombok annotation
 * @Data combines those lombok annotations (@Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
 * )
 *
 */
@Data
public class Contact {

	private String fullName2;
	private String mobile2;
	private String subject2;

	/**
	 * lombok @Data by default generate toString, but we need to override it
	 */
	@Override
	public String toString() {
		return "Contact [fullName=" + fullName2 + ", mobile=" + mobile2 + ", subject=" + subject2 + "]";
	}
}
