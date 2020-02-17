import React from 'react';
import axios from 'axios';
import {
    Button,
    Container,
    Dimmer,
    Icon,
    Image,
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
    <Container>
      <Header as='h2'>Dogs Roles with Humans</Header>
      <p>
        Domestic dogs inherited complex behaviors, such as bite inhibition, from
        their wolf ancestors, which would have been pack hunters with complex
        body language. These sophisticated forms of social cognition and
        communication may account for their trainability, playfulness, and
        ability to fit into human households and social situations, and these
        attributes have given dogs a relationship with humans that has enabled
        them to become one of the most successful species on the planet today.
      </p>
    </Container>
        )
    }
}
export default BlogList