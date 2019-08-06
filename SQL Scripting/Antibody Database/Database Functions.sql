---Antibuddies Function script
---CS 4550 Summer 2019
---This script contains all of the functions that are used in the antibuddies database.

USE antibuddies;


--------------------------------
---CREATE FUNCTIONS
--------------------------------

GO
---This function finds all questions from a course based on the course_id and question difficulty (qdifficulty)
CREATE FUNCTION questionsDifficulty (
	@courseid int,
	@difficulty int
)
RETURNS TABLE
AS 
RETURN
	SELECT q.question_id, q.citem_id, q.section, q.question, q.qdifficulty, q.atype, q.aresponse
	FROM
		PracticeQuestions q
		INNER JOIN CourseItems ci
		ON q.citem_id = ci.citem_id
		INNER JOIN Courses c
		ON c.course_id = ci.course_id
	WHERE
		q.qdifficulty = @difficulty AND c.course_id = @courseid
GO

---This function finds all panels from a course based on the course_id and panel difficulty (pdifficulty)
CREATE FUNCTION panelsDifficulty (
	@courseid int,
	@difficulty int
)
RETURNS TABLE
AS 
RETURN
	SELECT p.panel_id, p.citem_id, p.panelName, p.pdifficulty
	FROM
		Panels p
		INNER JOIN CourseItems ci
		ON p.citem_id = ci.citem_id
		INNER JOIN Courses c
		ON c.course_id = ci.course_id
	WHERE
		p.pdifficulty = @difficulty AND c.course_id = @courseid
GO

---Function to find panel based on course_id ane panelName.
CREATE FUNCTION panelsName (
	@courseid int,
	@pName nvarchar(25)
)
RETURNS TABLE
AS 
RETURN
	SELECT p.panel_id, p.citem_id, p.panelName, p.pdifficulty
	FROM
		Panels p
		INNER JOIN CourseItems ci
		ON p.citem_id = ci.citem_id
		INNER JOIN Courses c
		ON c.course_id = ci.course_id
	WHERE
		p.panelName = @pName AND c.course_id = @courseid

GO


---This function finds all of the panelScores for a User from a specific course.
CREATE FUNCTION userPanelScores (
	@courseid int,
	@userid int
)
RETURNS TABLE
AS
RETURN
	SELECT ps.panelScore_id, ps.panel_id, ps.user_id, ps.errors, ps.tries, ps.completed
	FROM
		PanelScores ps
		INNER JOIN Panels p
		ON p.panel_id = ps.panel_id
		INNER JOIN CourseItems ci
		ON ci.citem_id = p.citem_id
		INNER JOIN Courses c
		ON c.course_id = ci.course_id
	WHERE
		ps.user_id = @userid AND c.course_id = @courseid;

GO

---This function finds all of the questionScores for a User from a specific course.
CREATE FUNCTION userQuestionScores (
	@courseid int,
	@userid int
)
RETURNS TABLE
AS
RETURN
	SELECT pqs.qscore_id, pqs.question_id, pqs.user_id, pqs.correct, pqs.completed
	FROM
		PQScores pqs
		INNER JOIN PracticeQuestions pq
		ON pq.question_id = pqs.qscore_id
		INNER JOIN CourseItems ci
		ON ci.citem_id = pq.citem_id
		INNER JOIN Courses c
		ON c.course_id = ci.course_id
	WHERE
		pqs.user_id = @userid AND c.course_id = @courseid;
GO

---Function to find panelScores for a specific panel based by course id and panel id.
CREATE FUNCTION panelPanelScores (
	@courseid int,
	@panelid int
)
RETURNS TABLE
AS
RETURN
	SELECT ps.panelScore_id, ps.panel_id, ps.user_id, ps.errors, ps.tries, ps.completed
	FROM
		PanelScores ps
		INNER JOIN Panels p
		ON p.panel_id = ps.panel_id
		INNER JOIN CourseItems ci
		ON ci.citem_id = p.citem_id
		INNER JOIN Courses c
		ON c.course_id = ci.course_id
	WHERE
		ps.panel_id = @panelid AND c.course_id = @courseid;
GO

---Function to find questionScores for a specific question base by course id and question id
CREATE FUNCTION questionQuestionScores (
	@courseid int,
	@questionid int
)
RETURNS TABLE
AS
RETURN
	SELECT pqs.qscore_id, pqs.question_id, pqs.user_id, pqs.correct, pqs.completed
	FROM
		PQScores pqs
		INNER JOIN PracticeQuestions pq
		ON pq.question_id = pqs.qscore_id
		INNER JOIN CourseItems ci
		ON ci.citem_id = pq.citem_id
		INNER JOIN Courses c
		ON c.course_id = ci.course_id
	WHERE
		pqs.question_id = @questionid AND c.course_id = @courseid;

GO

---SELECT statements to test Functions.

SELECT *
FROM questionsDifficulty(1,1);

SELECT *
FROM panelsName(1,'Panel 1');

SELECT *
FROM panelsDifficulty(2,2);

SELECT *
FROM questionQuestionScores(1,3);

SELECT *
FROM panelPanelScores(1,1);

SELECT *
FROM userPanelScores(1,1);

SELECT *
FROM userQuestionScores(1,1);