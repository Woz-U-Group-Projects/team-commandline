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
          <Form action="@{/posts/create}" object="${post}" method="post">
           <Form.Group widths='equal'>
              <Form.Field
                id='form-input-control-first-name'
                control={Input}
                type="text"
                field="*{title}"
                class="${#fields.hasErrors('title')  ? 'form-control is-invalid' : 'form-control'}"
                label='Title'
                placeholder='New Tech start-up makes millions in 90 Days'
              />
            </Form.Group>
            <Form.Field
              id='form-textarea-control-opinion'
              control={TextArea}
              field="*{body}"
              class="${#fields.hasErrors('body') ? 'form-control is-invalid' : 'form-control'}"
              label='Content'
              placeholder='Opinion'
            />
          </Form>
          <Button
                  color="teal"
                  fluid
                  size="large"
                >
                  Submit
                </Button>
          <div class="form-group">
				<div class="${successMessage} ? 'alert alert-success' : ''" text="${successMessage}"></div>
			</div>
              </Segment>
          </React.Fragment>
        </Grid.Column>
      </Grid>
    );

export default PostForm
