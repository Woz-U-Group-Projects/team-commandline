import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Form, Input, TextArea, Button, Grid, Segment, Header} from 'semantic-ui-react';


const PostForm = () => (
  <Grid
        textAlign="center"
        style={{ height: "100vh" }}
        verticalAlign="middle"
      >
        <Grid.Column style={{ maxWidth: 950 }}>
          <Header as="h2" color="teal" textAlign="center">
            Make a Post and share 
          </Header>

          <React.Fragment>
          <Segment stacked>
          <Form>
           <Form.Group widths='equal'>
              <Form.Field
                id='form-input-control-first-name'
                control={Input}
                label='Title'
                placeholder='New Tech start-up makes millions in 90 Days'
              />
              <Form.Field
                id='form-input-control-last-name'
                control={Input}
                label='Author'
                placeholder='Full Name'
              />
            </Form.Group>
            <Form.Field
              id='form-textarea-control-opinion'
              control={TextArea}
              label='Content'
              placeholder='Opinion'
            />
            <Form.Field
              id='form-button-control-public'
              control={Button}
              content='Confirm'
              label='Share'
            />
          </Form>
              </Segment>
          </React.Fragment>
        </Grid.Column>
      </Grid>
    );

export default PostForm
