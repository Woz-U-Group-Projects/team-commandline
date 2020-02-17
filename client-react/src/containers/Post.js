import React from 'react'
import { Container, Header } from 'semantic-ui-react'

const Post = () => (
  <Container text>
    <Header as='h2'>Header</Header>
    <header replace="layout::site-header"></header>

<main id="posts">
<title text="${post.title}">View Post</title>
  <article>
    <h2 class="title" text="${post.title}">Post Title</h2>
    <div class="date">
      <i>Posted on</i>
      <span text="${#dates.format(post.date, 'dd-MMM-yyyy')}">22-May-2016</span>
      <span if="${post.author}" remove="tag">
        <i>by</i>
          <span text="${post.author.fullName != null ? post.author.fullName : post.author.userName}">Svetlin Nakov</span>
      </span>
    </div>
    <p class="content" text="${post.body}">Post content</p>
  </article>
</main>

  </Container>
)

export default Post