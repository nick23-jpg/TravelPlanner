# How to fill in the TravelPlanner docs

*This guide is for your team only. Don't commit it to the repo.*

## What's already done, and what's yours

| Kept as scaffolding (fine to use as-is) | Left for your team (this is what gets graded as *your* analysis) |
| --- | --- |
| File layout, headings, table formats | Purpose and Scope, written in your own words |
| Requirement, story and backlog IDs, and the links between them | Every `___` in a requirement: limits, options, your choices |
| Stakeholders, features, roles, categories (these come from your own proposal and Word SRS) | Every number in the non-functional requirements |
| The user story sentences ("As a… I want… so that…") | Story points, from your own estimation session |
| One worked example of acceptance criteria (US-01) | The rest of the acceptance criteria |
| Risk descriptions | Probability and Impact for every risk, most mitigations, and at least one risk of your own |
| Glossary | MoSCoW priority, rank and totals in the backlog |
| | Vision statement, goals, success measures |
| | Team roles and an AI-use statement in the README |

## Markers

- **[FILL]**: write this yourselves.
- **[REVIEW]**: read it, and change it if it doesn't match your plan.
- `___`: a number or choice the team decides.
- Grey "How to use this template" boxes: delete them once a file is done.

In VS Code, press **Ctrl+Shift+F** and search `[FILL]`, then `[REVIEW]`, then `___` to jump to every spot.

## Step 1: One team meeting (about an hour)

Decide these together first, because the other documents depend on them:

1. **Backend** for accounts and shared trips (e.g. Firebase).
2. **Scrum roles**: Product Owner, Scrum Master, Developers.
3. **Test device / emulator** and **minimum Android version**.
4. **MoSCoW priority** for each of the 21 backlog items.
5. **Story points**: planning poker on each story. Everyone shows 1, 2, 3, 5 or 8 at the same time; if the numbers differ a lot, the highest and lowest explain, then vote again.
6. **Risk ratings**: Low/Medium/High probability and impact for each risk, plus one or two new risks.

Write the answers down; that's most of the blanks filled already.

## Step 2: Split the writing

| Person | Files |
| --- | --- |
| A | `docs/RequirementsSpecification.md`: Purpose, Scope, review the functional requirements, fill the non-functional numbers |
| B | `docs/UserStories/UserStories.md`: acceptance criteria for US-02 to US-21, plus `docs/ProductVision.md` |
| C | `docs/RiskRoster.md`, `docs/ProductBacklog.md`, both READMEs |

Each person commits their own files from their own GitHub account, in a few commits over several days (e.g. "Add functional requirements", then "Add non-functional requirements"). That builds the meaningful commit history the rubric asks for.

## Step 3: Before you submit

- [ ] No `[FILL]`, `[REVIEW]` or `___` left anywhere
- [ ] All grey "How to use this template" boxes deleted
- [ ] Story points in `UserStories.md` match the Points column in `ProductBacklog.md`
- [ ] Backlog totals added up
- [ ] If you added or removed a requirement, the user stories and backlog still link to the right IDs
- [ ] Every file checked in GitHub's **Preview** (tables show as grids, links open)
- [ ] All three members have commits in the history
- [ ] AI-use statement in the README matches your instructor's policy
- [ ] This guide is **not** in the repo
