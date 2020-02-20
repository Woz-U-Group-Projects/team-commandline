import React from 'react';
import axios from 'axios';
import {
    Button,
    Container,
    Dimmer,
    Icon,
    Image,
    List,
    Item,
    Header,
    Message,
    Loader,
    Segment
} from 'semantic-ui-react';
import { BlogListURL } from "../constants"; 


const paragraph = <Image src='/images/wireframe/short-paragraph.png' />

class BlogList extends React.Component {

    state = {
        loading: false,
        error: null,
        data: []
    }


    render() {
        return (
        <Container each="p : ${latest3Posts}">
        <Header as='h2' text="${p.title}">Dogs Roles with Humans</Header>
        <List>
        <List.Item>
        <List.Icon name='users' />
        <List.Content text="${p.author}">Kamal N. Shaw</List.Content>
        </List.Item>
        <List.Item>
        <List.Icon name='marker' />
        <List.Content text="${#dates.format(p.date, 'dd-MMM-yyyy')}">02/20/2020</List.Content>
        </List.Item>
        </List>
        <p class="content" utext="${p.body}">
            Domestic dogs inherited complex behaviors, such as bite inhibition, from
            their wolf ancestors, which would have been pack hunters with complex
            body language. These sophisticated forms of social cognition and
            communication may account for their trainability, playfulness, and
            ability to fit into human households and social situations, and these
            attributes have given dogs a relationship with humans that has enabled
            them to become one of the most successful species on the planet today.
        </p>
        <Button content='Read Here' href="@{/posts/view/{id}/(id=${p.id})}" />
        </Container>
        )
    }
}
export default BlogList