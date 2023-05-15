<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* navigation/tree/quick_warp.twig */
class __TwigTemplate_0a365c5a9c0fc0d35a7dc9e8836e6bd2b0f1c6aa9725c353cb919cb89a107446 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        // line 1
        echo "<div class=\"pma_quick_warp\">
    ";
        // line 2
        if (($context["recent"] ?? null)) {
            echo ($context["recent"] ?? null);
        }
        // line 3
        echo "    ";
        if (($context["favorite"] ?? null)) {
            echo ($context["favorite"] ?? null);
        }
        // line 4
        echo "    <div class=\"clearfloat\"></div>
</div>
";
    }

    public function getTemplateName()
    {
        return "navigation/tree/quick_warp.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  49 => 4,  44 => 3,  40 => 2,  37 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("", "navigation/tree/quick_warp.twig", "C:\\Users\\Administrateur.OTR-2018-503\\Desktop\\Base de donnee Avancer\\phpMyAdmin-5.2.1-all-languages\\templates\\navigation\\tree\\quick_warp.twig");
    }
}
