package com.blankblog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blankblog.models.Post;
import com.blankblog.models.User;

@Service
public class PostServiceStub implements PostService{

	private List<Post> posts = new ArrayList<Post>(){
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 4998307454524834028L;

		{
			add(new Post(1L, "First Post", "<p>Line #1</p><p>Line #2</p>", null ) );
			add(new Post(2L, "Second Post", "Second post content:<ul><li>line 1</li><li>line 2</li></p>", new User(10L, "pesho10", "Peter Ivanov")));
			add(new Post(3L, "Post #3", "<p>The post number 3 nice</p>", new User(10L, "merry", null)));
			add(new Post(4L, "Forth Post", "<p>Not interesting post</p>", null));
			add(new Post(5L, "Post Number 5", "<p>Just posting</p>", null));
			add(new Post(6L, "Sixth Post", "<p>Another interesting post</p>", null));
		}};
		/* (non-Javadoc)
		 * @see spring.blog.services.PostService#findAll()
		 */
		@Override
		public List<Post> findAll() {
			return this.posts;
		}
		/* (non-Javadoc)
		 * @see spring.blog.services.PostService#findLatest5()
		 */
		@Override
		public List<Post> findLatest5() {
			return this.posts.stream().sorted( (a,b) -> b.getDate().compareTo(a.getDate()) ).limit(5).collect(Collectors.toList());
		}
		/* (non-Javadoc)
		 * @see spring.blog.services.PostService#findById(java.lang.Long)
		 */
		@Override
		public Post findById(Long id) {
			return this.posts.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
		}
		/* (non-Javadoc)
		 * @see spring.blog.services.PostService#create(spring.blog.models.Post)
		 */
		@Override
		public Post create(Post post) {
			// Calculate next post ID
			post.setId(this.posts.stream().mapToLong(p -> p.getId()).max().getAsLong() + 1);
			this.posts.add(post);
			return post;
		}
		/* (non-Javadoc)
		 * @see spring.blog.services.PostService#edit(spring.blog.models.Post)
		 */
		@Override
		public Post edit(Post post) {
			for( int i = 0; i < this.posts.size(); i++){
				if( Objects.equals(this.posts.get(i).getId(), post.getId())){
					this.posts.set(i, post);
					return post;
				}
			}
			throw new RuntimeException("Post not found: " + post.getId());
		}
		/* (non-Javadoc)
		 * @see spring.blog.services.PostService#deleteById(java.lang.Long)
		 */
		@Override
		public void deleteById(Long id) {
			for( int i = 0; i < this.posts.size(); i++){
				if( Objects.equals(this.posts.get(i).getId(), id)){
					this.posts.remove(i);				
				}
			}
			throw new RuntimeException("Post not found: " + id);		
		}
		@Override
		public Page<Post> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

}
