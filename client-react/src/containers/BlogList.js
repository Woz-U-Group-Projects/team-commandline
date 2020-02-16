import React from 'react';
import axios from 'axios';
import {
    Button,
    Container,
    Dimmer,
    Icon,
    Image,
    Item,
    Label,
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

    componentDidMount() {
        axios.get(BlogListURL)
            .then(res => {
                this.setState({ data: res.data, loading: false })
            })
            .catch(err => {
                this.setState({ error: err })
            })
    }

    render() {
        const { data, error, loading } = this.state;
        return (
            <Container>
                }
                {loading && <Segment>
                    <Dimmer active inverted>
                        <Loader inverted>Loading</Loader>
                    </Dimmer>

                    <Image src='https://react.semantic-ui.com/images/wireframe/short-paragraph.png' />
                </Segment>}
                <Item.Group divided>
                    <Item>
                        <Item.Image src='https://techcrunch.com/wp-content/uploads/2020/02/GettyImages-639030958.jpg?w=1390&crop=1' />
                        <Item.Content>
                            <Item.Header as='a'>My Neighbor Totoro</Item.Header>
                            <Item.Meta>
                                <span className='cinema'>IFC Cinema</span>
                            </Item.Meta>
                            <Item.Description>{paragraph}</Item.Description>
                            <Item.Extra>
                                <Button primary floated='right' icon labelPosition="right">
                                    Add to cart
            <Icon name='add to cart' />
                                </Button>
                                <Label>Limited</Label>
                            </Item.Extra>
                        </Item.Content>
                    </Item>
                </Item.Group>
            </Container>
        )
    }
}
export default BlogList