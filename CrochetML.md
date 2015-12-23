# CrochetML Tags

Standard crochet pattern symbols can be found here: http://www.craftyarncouncil.com/crochet.html

| Tag | Description | Etc |
| --- | ----------- | --- |
| author | Pattern author's first and last name or username | `<author>sgreenholtz</author>` |
| ball-weight | The weight of a single ball of yarn. | `<ball-weight unit='g'>50</ball-weight>` |
| chain | Create a chain of as many stitches as specified | `<chain>15</chain>` |
| dimensions | Final pattern dimensions, rendered as free text | `<dimensions>2.5 in tall, 3.5 in wide</dimensions>` |
| directions | Pattern directions | |
| double-crochet | Create specified number of double crochet stitches | `<double-crochet>90</double-crochet>` |
| double-crochet-together | Double crochet together specified number, default 2 | `<double-crochet-together>6</double-crochet-together>` |
| from-stitch-holder | Follow instructions following the stitch holder | |
| gauge | Instructions for the gauge specifying stitch type | `<gauge type="sc">...</gauge>` |
| general-information | General information about the pattern |
| half-double-crochet | Create specified number of double crochet stitches | `<half-double-crochet>90</half-double-crochet>` |
| hook | Hook for use in pattern, specify size | `<hook size="3.25mm/D" />` |
| in-stitch | Do a stitch in specified stitch location | `<in-stitch location="4ch space"><double-crochet>10</double-crochet></in-stitch>` |
| | Also works with back loop | `<in-stitch location="fl><half-double-crochet>20</half-double-crochet>` |
| join | Used in crochet in the round, shorthand for `<in-stitch location="beginning-chain"><slip-stitch /></in-stitch>` | |
| magic-circle | Make a "magic circle" loop for crochetting in the round | |
| materials | Materials needed to completed the pattern | |
| notion | Any notion withotu a specific tag | `<notion type="button" quantity="3" />` |
| repeat | Repeat the instructions a number of times or to the end | `<repeat until="end"><single-crochet /></repeat>` |
| row | A single row, number specified | `<row number="2">...</row>` |
| single crochet | Create specified number of single crochet stitches | `<single-crochet>90</single-crochet>` |
| slip-stitch | Create a slip stitch | `<in-stitch location="top chain"><slip-stitch /></in-stitch>`|
| stitch | A stitch type, not otherwise defined | `<stitch type="bobble" ref="bob">2</stitch>` |
| stitch-definition | Defines a non-standard stitch, include reference |  `<stitch-definition ref="bob">Five dc in 1 ch space...</stitch-definition>` |
| stitch-gauge | The number of stitches (horizontally) per unit of measurement | `<stitch-gauge unit="st/in">3.5</stitch-gauge>` |
| stitch-marker | Place stitch marker in specified stitch |  `<in-stitch location="last st"><stitch-marker /></in-stitch>` |
| switch-colors | Switch from one color to another, color indicated in attribute | `<switch-colors color="main" />` |
| title | Title of the pattern | `<title>Cupcake Afghan</title>` |
| yarn | A yarn used in the pattern. Typeref must be already define in yarn-type | `<yarn id="y1" label="Main Color" symbol="MC" typeref="wool"> ... </yarn>` |
| yarn-type | Define a type of yarn for use in the project | `<yarn-type id="wool" brand="Lorna's Laces" weight="fingering"/>...</yarn-type>` |
